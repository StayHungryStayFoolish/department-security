import { IJhiAuthPermResMySuffix } from 'app/shared/model//jhi-auth-perm-res-my-suffix.model';

export interface IJhiPermissionMySuffix {
  id?: number;
  permissionName?: string;
  permissions?: IJhiAuthPermResMySuffix[];
}

export const defaultValue: Readonly<IJhiPermissionMySuffix> = {};
