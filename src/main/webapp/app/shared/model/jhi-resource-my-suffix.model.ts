import { IJhiAuthPermResMySuffix } from 'app/shared/model//jhi-auth-perm-res-my-suffix.model';

export interface IJhiResourceMySuffix {
  id?: number;
  resourceName?: string;
  resources?: IJhiAuthPermResMySuffix[];
}

export const defaultValue: Readonly<IJhiResourceMySuffix> = {};
