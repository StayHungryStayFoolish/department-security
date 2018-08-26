import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import JhiAuthPermResMySuffix from './jhi-auth-perm-res-my-suffix';
import JhiAuthPermResMySuffixDetail from './jhi-auth-perm-res-my-suffix-detail';
import JhiAuthPermResMySuffixUpdate from './jhi-auth-perm-res-my-suffix-update';
import JhiAuthPermResMySuffixDeleteDialog from './jhi-auth-perm-res-my-suffix-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={JhiAuthPermResMySuffixUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={JhiAuthPermResMySuffixUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={JhiAuthPermResMySuffixDetail} />
      <ErrorBoundaryRoute path={match.url} component={JhiAuthPermResMySuffix} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={JhiAuthPermResMySuffixDeleteDialog} />
  </>
);

export default Routes;
