import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IJhiDepartmentMySuffix, defaultValue } from 'app/shared/model/jhi-department-my-suffix.model';

export const ACTION_TYPES = {
  FETCH_JHIDEPARTMENT_LIST: 'jhiDepartment/FETCH_JHIDEPARTMENT_LIST',
  FETCH_JHIDEPARTMENT: 'jhiDepartment/FETCH_JHIDEPARTMENT',
  CREATE_JHIDEPARTMENT: 'jhiDepartment/CREATE_JHIDEPARTMENT',
  UPDATE_JHIDEPARTMENT: 'jhiDepartment/UPDATE_JHIDEPARTMENT',
  DELETE_JHIDEPARTMENT: 'jhiDepartment/DELETE_JHIDEPARTMENT',
  RESET: 'jhiDepartment/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IJhiDepartmentMySuffix>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type JhiDepartmentMySuffixState = Readonly<typeof initialState>;

// Reducer

export default (state: JhiDepartmentMySuffixState = initialState, action): JhiDepartmentMySuffixState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_JHIDEPARTMENT_LIST):
    case REQUEST(ACTION_TYPES.FETCH_JHIDEPARTMENT):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_JHIDEPARTMENT):
    case REQUEST(ACTION_TYPES.UPDATE_JHIDEPARTMENT):
    case REQUEST(ACTION_TYPES.DELETE_JHIDEPARTMENT):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_JHIDEPARTMENT_LIST):
    case FAILURE(ACTION_TYPES.FETCH_JHIDEPARTMENT):
    case FAILURE(ACTION_TYPES.CREATE_JHIDEPARTMENT):
    case FAILURE(ACTION_TYPES.UPDATE_JHIDEPARTMENT):
    case FAILURE(ACTION_TYPES.DELETE_JHIDEPARTMENT):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_JHIDEPARTMENT_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_JHIDEPARTMENT):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_JHIDEPARTMENT):
    case SUCCESS(ACTION_TYPES.UPDATE_JHIDEPARTMENT):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_JHIDEPARTMENT):
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

const apiUrl = 'api/jhi-departments';

// Actions

export const getEntities: ICrudGetAllAction<IJhiDepartmentMySuffix> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_JHIDEPARTMENT_LIST,
  payload: axios.get<IJhiDepartmentMySuffix>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<IJhiDepartmentMySuffix> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_JHIDEPARTMENT,
    payload: axios.get<IJhiDepartmentMySuffix>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IJhiDepartmentMySuffix> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_JHIDEPARTMENT,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IJhiDepartmentMySuffix> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_JHIDEPARTMENT,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<IJhiDepartmentMySuffix> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_JHIDEPARTMENT,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
