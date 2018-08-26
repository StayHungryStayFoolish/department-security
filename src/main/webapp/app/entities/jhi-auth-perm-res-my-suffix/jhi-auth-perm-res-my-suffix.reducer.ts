import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IJhiAuthPermResMySuffix, defaultValue } from 'app/shared/model/jhi-auth-perm-res-my-suffix.model';

export const ACTION_TYPES = {
  FETCH_JHIAUTHPERMRES_LIST: 'jhiAuthPermRes/FETCH_JHIAUTHPERMRES_LIST',
  FETCH_JHIAUTHPERMRES: 'jhiAuthPermRes/FETCH_JHIAUTHPERMRES',
  CREATE_JHIAUTHPERMRES: 'jhiAuthPermRes/CREATE_JHIAUTHPERMRES',
  UPDATE_JHIAUTHPERMRES: 'jhiAuthPermRes/UPDATE_JHIAUTHPERMRES',
  DELETE_JHIAUTHPERMRES: 'jhiAuthPermRes/DELETE_JHIAUTHPERMRES',
  RESET: 'jhiAuthPermRes/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IJhiAuthPermResMySuffix>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type JhiAuthPermResMySuffixState = Readonly<typeof initialState>;

// Reducer

export default (state: JhiAuthPermResMySuffixState = initialState, action): JhiAuthPermResMySuffixState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_JHIAUTHPERMRES_LIST):
    case REQUEST(ACTION_TYPES.FETCH_JHIAUTHPERMRES):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_JHIAUTHPERMRES):
    case REQUEST(ACTION_TYPES.UPDATE_JHIAUTHPERMRES):
    case REQUEST(ACTION_TYPES.DELETE_JHIAUTHPERMRES):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_JHIAUTHPERMRES_LIST):
    case FAILURE(ACTION_TYPES.FETCH_JHIAUTHPERMRES):
    case FAILURE(ACTION_TYPES.CREATE_JHIAUTHPERMRES):
    case FAILURE(ACTION_TYPES.UPDATE_JHIAUTHPERMRES):
    case FAILURE(ACTION_TYPES.DELETE_JHIAUTHPERMRES):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_JHIAUTHPERMRES_LIST):
      return {
        ...state,
        loading: false,
        totalItems: action.payload.headers['x-total-count'],
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_JHIAUTHPERMRES):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_JHIAUTHPERMRES):
    case SUCCESS(ACTION_TYPES.UPDATE_JHIAUTHPERMRES):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_JHIAUTHPERMRES):
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

const apiUrl = 'api/jhi-auth-perm-res';

// Actions

export const getEntities: ICrudGetAllAction<IJhiAuthPermResMySuffix> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_JHIAUTHPERMRES_LIST,
    payload: axios.get<IJhiAuthPermResMySuffix>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<IJhiAuthPermResMySuffix> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_JHIAUTHPERMRES,
    payload: axios.get<IJhiAuthPermResMySuffix>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IJhiAuthPermResMySuffix> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_JHIAUTHPERMRES,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IJhiAuthPermResMySuffix> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_JHIAUTHPERMRES,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<IJhiAuthPermResMySuffix> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_JHIAUTHPERMRES,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
