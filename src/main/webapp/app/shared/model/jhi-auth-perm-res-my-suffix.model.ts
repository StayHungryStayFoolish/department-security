import { IJhiPermissionMySuffix } from 'app/shared/model//jhi-permission-my-suffix.model';
import { IJhiResourceMySuffix } from 'app/shared/model//jhi-resource-my-suffix.model';

export interface IJhiAuthPermResMySuffix {
  id?: number;
  authorityName?: string;
  permissionName?: string;
  resourceName?: string;
  jhiPermission?: IJhiPermissionMySuffix;
  jhiResource?: IJhiResourceMySuffix;
}

export const defaultValue: Readonly<IJhiAuthPermResMySuffix> = {};
