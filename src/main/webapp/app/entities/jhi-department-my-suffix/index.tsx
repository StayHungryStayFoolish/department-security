import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import JhiDepartmentMySuffix from './jhi-department-my-suffix';
import JhiDepartmentMySuffixDetail from './jhi-department-my-suffix-detail';
import JhiDepartmentMySuffixUpdate from './jhi-department-my-suffix-update';
import JhiDepartmentMySuffixDeleteDialog from './jhi-department-my-suffix-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={JhiDepartmentMySuffixUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={JhiDepartmentMySuffixUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={JhiDepartmentMySuffixDetail} />
      <ErrorBoundaryRoute path={match.url} component={JhiDepartmentMySuffix} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={JhiDepartmentMySuffixDeleteDialog} />
  </>
);

export default Routes;
