import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './jhi-auth-perm-res-my-suffix.reducer';
import { IJhiAuthPermResMySuffix } from 'app/shared/model/jhi-auth-perm-res-my-suffix.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IJhiAuthPermResMySuffixDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: number }> {}

export class JhiAuthPermResMySuffixDetail extends React.Component<IJhiAuthPermResMySuffixDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { jhiAuthPermResEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.detail.title">JhiAuthPermRes</Translate> [<b>
              {jhiAuthPermResEntity.id}
            </b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="authorityName">
                <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.authorityName">Authority Name</Translate>
              </span>
            </dt>
            <dd>{jhiAuthPermResEntity.authorityName}</dd>
            <dt>
              <span id="permissionName">
                <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.permissionName">Permission Name</Translate>
              </span>
            </dt>
            <dd>{jhiAuthPermResEntity.permissionName}</dd>
            <dt>
              <span id="resourceName">
                <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.resourceName">Resource Name</Translate>
              </span>
            </dt>
            <dd>{jhiAuthPermResEntity.resourceName}</dd>
            <dt>
              <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.jhiPermission">Jhi Permission</Translate>
            </dt>
            <dd>{jhiAuthPermResEntity.jhiPermission ? jhiAuthPermResEntity.jhiPermission.id : ''}</dd>
            <dt>
              <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.jhiResource">Jhi Resource</Translate>
            </dt>
            <dd>{jhiAuthPermResEntity.jhiResource ? jhiAuthPermResEntity.jhiResource.id : ''}</dd>
          </dl>
          <Button tag={Link} to="/entity/jhi-auth-perm-res-my-suffix" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>&nbsp;
          <Button tag={Link} to={`/entity/jhi-auth-perm-res-my-suffix/${jhiAuthPermResEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.edit">Edit</Translate>
            </span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ jhiAuthPermRes }: IRootState) => ({
  jhiAuthPermResEntity: jhiAuthPermRes.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(JhiAuthPermResMySuffixDetail);
