import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IJhiPermissionMySuffix, defaultValue } from 'app/shared/model/jhi-permission-my-suffix.model';

export const ACTION_TYPES = {
  FETCH_JHIPERMISSION_LIST: 'jhiPermission/FETCH_JHIPERMISSION_LIST',
  FETCH_JHIPERMISSION: 'jhiPermission/FETCH_JHIPERMISSION',
  CREATE_JHIPERMISSION: 'jhiPermission/CREATE_JHIPERMISSION',
  UPDATE_JHIPERMISSION: 'jhiPermission/UPDATE_JHIPERMISSION',
  DELETE_JHIPERMISSION: 'jhiPermission/DELETE_JHIPERMISSION',
  RESET: 'jhiPermission/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IJhiPermissionMySuffix>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type JhiPermissionMySuffixState = Readonly<typeof initialState>;

// Reducer

export default (state: JhiPermissionMySuffixState = initialState, action): JhiPermissionMySuffixState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_JHIPERMISSION_LIST):
    case REQUEST(ACTION_TYPES.FETCH_JHIPERMISSION):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_JHIPERMISSION):
    case REQUEST(ACTION_TYPES.UPDATE_JHIPERMISSION):
    case REQUEST(ACTION_TYPES.DELETE_JHIPERMISSION):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_JHIPERMISSION_LIST):
    case FAILURE(ACTION_TYPES.FETCH_JHIPERMISSION):
    case FAILURE(ACTION_TYPES.CREATE_JHIPERMISSION):
    case FAILURE(ACTION_TYPES.UPDATE_JHIPERMISSION):
    case FAILURE(ACTION_TYPES.DELETE_JHIPERMISSION):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_JHIPERMISSION_LIST):
      return {
        ...state,
        loading: false,
        totalItems: action.payload.headers['x-total-count'],
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_JHIPERMISSION):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_JHIPERMISSION):
    case SUCCESS(ACTION_TYPES.UPDATE_JHIPERMISSION):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_JHIPERMISSION):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: {}
      };
    case ACTION_TYPES.RESET:
      return {
        ...initialState
      };
    default:
      return state;
  }
};

const apiUrl = 'api/jhi-permissions';

// Actions

export const getEntities: ICrudGetAllAction<IJhiPermissionMySuffix> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_JHIPERMISSION_LIST,
    payload: axios.get<IJhiPermissionMySuffix>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<IJhiPermissionMySuffix> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_JHIPERMISSION,
    payload: axios.get<IJhiPermissionMySuffix>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IJhiPermissionMySuffix> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_JHIPERMISSION,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IJhiPermissionMySuffix> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_JHIPERMISSION,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<IJhiPermissionMySuffix> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_JHIPERMISSION,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
