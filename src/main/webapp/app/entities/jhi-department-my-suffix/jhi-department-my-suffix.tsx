import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAllAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './jhi-department-my-suffix.reducer';
import { IJhiDepartmentMySuffix } from 'app/shared/model/jhi-department-my-suffix.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IJhiDepartmentMySuffixProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export class JhiDepartmentMySuffix extends React.Component<IJhiDepartmentMySuffixProps> {
  componentDidMount() {
    this.props.getEntities();
  }

  render() {
    const { jhiDepartmentList, match } = this.props;
    return (
      <div>
        <h2 id="jhi-department-my-suffix-heading">
          <Translate contentKey="departmentSecurityApp.jhiDepartment.home.title">Jhi Departments</Translate>
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />&nbsp;
            <Translate contentKey="departmentSecurityApp.jhiDepartment.home.createLabel">Create new Jhi Department</Translate>
          </Link>
        </h2>
        <div className="table-responsive">
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="global.field.id">ID</Translate>
                </th>
                <th>
                  <Translate contentKey="departmentSecurityApp.jhiDepartment.departmentName">Department Name</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {jhiDepartmentList.map((jhiDepartment, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${jhiDepartment.id}`} color="link" size="sm">
                      {jhiDepartment.id}
                    </Button>
                  </td>
                  <td>{jhiDepartment.departmentName}</td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${jhiDepartment.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${jhiDepartment.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${jhiDepartment.id}/delete`} color="danger" size="sm">
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
      </div>
    );
  }
}

const mapStateToProps = ({ jhiDepartment }: IRootState) => ({
  jhiDepartmentList: jhiDepartment.entities
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(JhiDepartmentMySuffix);
