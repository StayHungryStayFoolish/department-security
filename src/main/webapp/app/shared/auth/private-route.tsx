import React from 'react';
import { connect } from 'react-redux';
import { Route, Redirect, RouteProps } from 'react-router-dom';
import { Translate } from 'react-jhipster';
import { IRootState } from 'app/shared/reducers';
import ErrorBoundary from 'app/shared/error/error-boundary';

interface IOwnProps extends RouteProps {
  hasAnyAuthorities?: string[];
}

export interface IPrivateRouteProps extends IOwnProps, StateProps {}

export const PrivateRouteComponent = ({
  component: Component,
  isAuthenticated,
  isAuthorized,
  hasAnyAuthorities = [],
  ...rest
}: IPrivateRouteProps) => {
  console.log("99988999999")
  console.log(isAuthorized)
  const checkAuthorities = props =>
    isAuthorized ? (
      <ErrorBoundary>
        <Component {...props} />
      </ErrorBoundary>
    ) : (
      <div className="insufficient-authority">
        <div className="alert alert-danger">
          <Translate contentKey="error.http.403">You are not authorized to access this page.</Translate>
        </div>
      </div>
    );

  const renderRedirect = props =>
    isAuthenticated ? (
      checkAuthorities(props)
    ) : (
      <Redirect
        to={{
          pathname: '/login',
          search: props.location.search,
          state: { from: props.location }
        }}
      />
    );

  if (!Component) throw new Error(`A component needs to be specified for private route for path ${(rest as any).path}`);

  return <Route {...rest} render={renderRedirect} />;
};

export const hasAnyAuthority = (departments: string[], hasAnyAuthorities: string[]) => {
  if (departments && departments.length !== 0) {
    console.log('1');
    if (hasAnyAuthorities.length === 0) {
      console.log('2');
      return true;
    }
    console.log('3');
    console.log(hasAnyAuthorities.some(auth => departments.includes(auth)));
    return hasAnyAuthorities.some(auth => departments.includes(auth));
  }
  console.log('4');
  return false;
};

const mapStateToProps = ({ authentication: { isAuthenticated, account } }: IRootState, { hasAnyAuthorities = [] }: IOwnProps) => {
  console.log("9090")
  console.log(account.departments)
  console.log(hasAnyAuthorities)
  console.log(hasAnyAuthority(account.departments, hasAnyAuthorities))
  console.log("-------")
  return ({
  isAuthenticated,
  isAuthorized: hasAnyAuthority(account.departments, hasAnyAuthorities)
})};
type StateProps = ReturnType<typeof mapStateToProps>;

/**
 * A route wrapped in an authentication check so that routing happens only when you are authenticated.
 * Accepts same props as React router Route.
 * The route also checks for authorization if hasAnyAuthorities is specified.
 */
export const PrivateRoute = connect<StateProps, undefined, IOwnProps>(
  mapStateToProps,
  null,
  null,
  { pure: false }
)(PrivateRouteComponent);

export default PrivateRoute;
