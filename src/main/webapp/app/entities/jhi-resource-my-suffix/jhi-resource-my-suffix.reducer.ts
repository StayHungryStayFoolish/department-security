import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IJhiResourceMySuffix, defaultValue } from 'app/shared/model/jhi-resource-my-suffix.model';

export const ACTION_TYPES = {
  FETCH_JHIRESOURCE_LIST: 'jhiResource/FETCH_JHIRESOURCE_LIST',
  FETCH_JHIRESOURCE: 'jhiResource/FETCH_JHIRESOURCE',
  CREATE_JHIRESOURCE: 'jhiResource/CREATE_JHIRESOURCE',
  UPDATE_JHIRESOURCE: 'jhiResource/UPDATE_JHIRESOURCE',
  DELETE_JHIRESOURCE: 'jhiResource/DELETE_JHIRESOURCE',
  RESET: 'jhiResource/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IJhiResourceMySuffix>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type JhiResourceMySuffixState = Readonly<typeof initialState>;

// Reducer

export default (state: JhiResourceMySuffixState = initialState, action): JhiResourceMySuffixState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_JHIRESOURCE_LIST):
    case REQUEST(ACTION_TYPES.FETCH_JHIRESOURCE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_JHIRESOURCE):
    case REQUEST(ACTION_TYPES.UPDATE_JHIRESOURCE):
    case REQUEST(ACTION_TYPES.DELETE_JHIRESOURCE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_JHIRESOURCE_LIST):
    case FAILURE(ACTION_TYPES.FETCH_JHIRESOURCE):
    case FAILURE(ACTION_TYPES.CREATE_JHIRESOURCE):
    case FAILURE(ACTION_TYPES.UPDATE_JHIRESOURCE):
    case FAILURE(ACTION_TYPES.DELETE_JHIRESOURCE):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_JHIRESOURCE_LIST):
      return {
        ...state,
        loading: false,
        totalItems: action.payload.headers['x-total-count'],
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_JHIRESOURCE):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_JHIRESOURCE):
    case SUCCESS(ACTION_TYPES.UPDATE_JHIRESOURCE):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_JHIRESOURCE):
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

const apiUrl = 'api/jhi-resources';

// Actions

export const getEntities: ICrudGetAllAction<IJhiResourceMySuffix> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_JHIRESOURCE_LIST,
    payload: axios.get<IJhiResourceMySuffix>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<IJhiResourceMySuffix> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_JHIRESOURCE,
    payload: axios.get<IJhiResourceMySuffix>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IJhiResourceMySuffix> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_JHIRESOURCE,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IJhiResourceMySuffix> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_JHIRESOURCE,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<IJhiResourceMySuffix> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_JHIRESOURCE,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
