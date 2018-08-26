import { combineReducers } from 'redux';
import { loadingBarReducer as loadingBar } from 'react-redux-loading-bar';

import locale, { LocaleState } from './locale';
import authentication, { AuthenticationState } from './authentication';
import applicationProfile, { ApplicationProfileState } from './application-profile';

import administration, { AdministrationState } from 'app/modules/administration/administration.reducer';
import userManagement, { UserManagementState } from 'app/modules/administration/user-management/user-management.reducer';
import register, { RegisterState } from 'app/modules/account/register/register.reducer';
import activate, { ActivateState } from 'app/modules/account/activate/activate.reducer';
import password, { PasswordState } from 'app/modules/account/password/password.reducer';
import settings, { SettingsState } from 'app/modules/account/settings/settings.reducer';
import passwordReset, { PasswordResetState } from 'app/modules/account/password-reset/password-reset.reducer';
// prettier-ignore
import jhiDepartment, {
  JhiDepartmentMySuffixState
} from 'app/entities/jhi-department-my-suffix/jhi-department-my-suffix.reducer';
// prettier-ignore
import jhiPermission, {
  JhiPermissionMySuffixState
} from 'app/entities/jhi-permission-my-suffix/jhi-permission-my-suffix.reducer';
// prettier-ignore
import jhiResource, {
  JhiResourceMySuffixState
} from 'app/entities/jhi-resource-my-suffix/jhi-resource-my-suffix.reducer';
// prettier-ignore
import jhiAuthPermRes, {
  JhiAuthPermResMySuffixState
} from 'app/entities/jhi-auth-perm-res-my-suffix/jhi-auth-perm-res-my-suffix.reducer';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

export interface IRootState {
  readonly authentication: AuthenticationState;
  readonly locale: LocaleState;
  readonly applicationProfile: ApplicationProfileState;
  readonly administration: AdministrationState;
  readonly userManagement: UserManagementState;
  readonly register: RegisterState;
  readonly activate: ActivateState;
  readonly passwordReset: PasswordResetState;
  readonly password: PasswordState;
  readonly settings: SettingsState;
  readonly jhiDepartment: JhiDepartmentMySuffixState;
  readonly jhiPermission: JhiPermissionMySuffixState;
  readonly jhiResource: JhiResourceMySuffixState;
  readonly jhiAuthPermRes: JhiAuthPermResMySuffixState;
  /* jhipster-needle-add-reducer-type - JHipster will add reducer type here */
  readonly loadingBar: any;
}

const rootReducer = combineReducers<IRootState>({
  authentication,
  locale,
  applicationProfile,
  administration,
  userManagement,
  register,
  activate,
  passwordReset,
  password,
  settings,
  jhiDepartment,
  jhiPermission,
  jhiResource,
  jhiAuthPermRes,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
  loadingBar
});

export default rootReducer;
