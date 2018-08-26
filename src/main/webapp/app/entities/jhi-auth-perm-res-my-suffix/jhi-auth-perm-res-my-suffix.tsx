import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAllAction, getSortState, IPaginationBaseState, getPaginationItemsNumber, JhiPagination } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './jhi-auth-perm-res-my-suffix.reducer';
import { IJhiAuthPermResMySuffix } from 'app/shared/model/jhi-auth-perm-res-my-suffix.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface IJhiAuthPermResMySuffixProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export type IJhiAuthPermResMySuffixState = IPaginationBaseState;

export class JhiAuthPermResMySuffix extends React.Component<IJhiAuthPermResMySuffixProps, IJhiAuthPermResMySuffixState> {
  state: IJhiAuthPermResMySuffixState = {
    ...getSortState(this.props.location, ITEMS_PER_PAGE)
  };

  componentDidMount() {
    this.getEntities();
  }

  sort = prop => () => {
    this.setState(
      {
        activePage: 0,
        order: this.state.order === 'asc' ? 'desc' : 'asc',
        sort: prop
      },
      () => this.sortEntities()
    );
  };

  sortEntities() {
    this.getEntities();
    this.props.history.push(`${this.props.location.pathname}?page=${this.state.activePage}&sort=${this.state.sort},${this.state.order}`);
  }

  handlePagination = activePage => this.setState({ activePage }, () => this.sortEntities());

  getEntities = () => {
    const { activePage, itemsPerPage, sort, order } = this.state;
    this.props.getEntities(activePage, itemsPerPage, `${sort},${order}`);
  };

  render() {
    const { jhiAuthPermResList, match, totalItems } = this.props;
    return (
      <div>
        <h2 id="jhi-auth-perm-res-my-suffix-heading">
          <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.home.title">Jhi Auth Perm Res</Translate>
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />&nbsp;
            <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.home.createLabel">Create new Jhi Auth Perm Res</Translate>
          </Link>
        </h2>
        <div className="table-responsive">
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={this.sort('id')}>
                  <Translate contentKey="global.field.id">ID</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('authorityName')}>
                  <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.authorityName">Authority Name</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('permissionName')}>
                  <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.permissionName">Permission Name</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('resourceName')}>
                  <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.resourceName">Resource Name</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th>
                  <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.jhiPermission">Jhi Permission</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th>
                  <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.jhiResource">Jhi Resource</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {jhiAuthPermResList.map((jhiAuthPermRes, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${jhiAuthPermRes.id}`} color="link" size="sm">
                      {jhiAuthPermRes.id}
                    </Button>
                  </td>
                  <td>{jhiAuthPermRes.authorityName}</td>
                  <td>{jhiAuthPermRes.permissionName}</td>
                  <td>{jhiAuthPermRes.resourceName}</td>
                  <td>
                    {jhiAuthPermRes.jhiPermission ? (
                      <Link to={`jhiPermission/${jhiAuthPermRes.jhiPermission.id}`}>{jhiAuthPermRes.jhiPermission.id}</Link>
                    ) : (
                      ''
                    )}
                  </td>
                  <td>
                    {jhiAuthPermRes.jhiResource ? (
                      <Link to={`jhiResource/${jhiAuthPermRes.jhiResource.id}`}>{jhiAuthPermRes.jhiResource.id}</Link>
                    ) : (
                      ''
                    )}
                  </td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${jhiAuthPermRes.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${jhiAuthPermRes.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${jhiAuthPermRes.id}/delete`} color="danger" size="sm">
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        </div>
        <Row className="justify-content-center">
          <JhiPagination
            items={getPaginationItemsNumber(totalItems, this.state.itemsPerPage)}
            activePage={this.state.activePage}
            onSelect={this.handlePagination}
            maxButtons={5}
          />
        </Row>
      </div>
    );
  }
}

const mapStateToProps = ({ jhiAuthPermRes }: IRootState) => ({
  jhiAuthPermResList: jhiAuthPermRes.entities,
  totalItems: jhiAuthPermRes.totalItems
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(JhiAuthPermResMySuffix);
