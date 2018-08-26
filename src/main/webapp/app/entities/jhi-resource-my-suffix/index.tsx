import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import JhiResourceMySuffix from './jhi-resource-my-suffix';
import JhiResourceMySuffixDetail from './jhi-resource-my-suffix-detail';
import JhiResourceMySuffixUpdate from './jhi-resource-my-suffix-update';
import JhiResourceMySuffixDeleteDialog from './jhi-resource-my-suffix-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={JhiResourceMySuffixUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={JhiResourceMySuffixUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={JhiResourceMySuffixDetail} />
      <ErrorBoundaryRoute path={match.url} component={JhiResourceMySuffix} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={JhiResourceMySuffixDeleteDialog} />
  </>
);

export default Routes;
