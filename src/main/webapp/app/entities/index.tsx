import React from 'react';
import { Switch } from 'react-router-dom';

// tslint:disable-next-line:no-unused-variable
import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import JhiDepartmentMySuffix from './jhi-department-my-suffix';
import JhiPermissionMySuffix from './jhi-permission-my-suffix';
import JhiResourceMySuffix from './jhi-resource-my-suffix';
import JhiAuthPermResMySuffix from './jhi-auth-perm-res-my-suffix';
/* jhipster-needle-add-route-import - JHipster will add routes here */

const Routes = ({ match }) => (
  <div>
    <Switch>
      {/* prettier-ignore */}
      <ErrorBoundaryRoute path={`${match.url}/jhi-department-my-suffix`} component={JhiDepartmentMySuffix} />
      <ErrorBoundaryRoute path={`${match.url}/jhi-permission-my-suffix`} component={JhiPermissionMySuffix} />
      <ErrorBoundaryRoute path={`${match.url}/jhi-resource-my-suffix`} component={JhiResourceMySuffix} />
      <ErrorBoundaryRoute path={`${match.url}/jhi-auth-perm-res-my-suffix`} component={JhiAuthPermResMySuffix} />
      {/* jhipster-needle-add-route-path - JHipster will routes here */}
    </Switch>
  </div>
);

export default Routes;
