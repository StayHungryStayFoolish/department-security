import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import JhiPermissionMySuffix from './jhi-permission-my-suffix';
import JhiPermissionMySuffixDetail from './jhi-permission-my-suffix-detail';
import JhiPermissionMySuffixUpdate from './jhi-permission-my-suffix-update';
import JhiPermissionMySuffixDeleteDialog from './jhi-permission-my-suffix-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={JhiPermissionMySuffixUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={JhiPermissionMySuffixUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={JhiPermissionMySuffixDetail} />
      <ErrorBoundaryRoute path={match.url} component={JhiPermissionMySuffix} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={JhiPermissionMySuffixDeleteDialog} />
  </>
);

export default Routes;
