import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { IJhiPermissionMySuffix } from 'app/shared/model/jhi-permission-my-suffix.model';
import { getEntities as getJhiPermissions } from 'app/entities/jhi-permission-my-suffix/jhi-permission-my-suffix.reducer';
import { IJhiResourceMySuffix } from 'app/shared/model/jhi-resource-my-suffix.model';
import { getEntities as getJhiResources } from 'app/entities/jhi-resource-my-suffix/jhi-resource-my-suffix.reducer';
import { getEntity, updateEntity, createEntity, reset } from './jhi-auth-perm-res-my-suffix.reducer';
import { IJhiAuthPermResMySuffix } from 'app/shared/model/jhi-auth-perm-res-my-suffix.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer } from 'app/shared/util/date-utils';
import { keysToValues } from 'app/shared/util/entity-utils';

export interface IJhiAuthPermResMySuffixUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: number }> {}

export interface IJhiAuthPermResMySuffixUpdateState {
  isNew: boolean;
  jhiPermissionId: number;
  jhiResourceId: number;
}

export class JhiAuthPermResMySuffixUpdate extends React.Component<IJhiAuthPermResMySuffixUpdateProps, IJhiAuthPermResMySuffixUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
      jhiPermissionId: 0,
      jhiResourceId: 0,
      isNew: !this.props.match.params || !this.props.match.params.id
    };
  }

  componentDidMount() {
    if (this.state.isNew) {
      this.props.reset();
    } else {
      this.props.getEntity(this.props.match.params.id);
    }

    this.props.getJhiPermissions();
    this.props.getJhiResources();
  }

  saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const { jhiAuthPermResEntity } = this.props;
      const entity = {
        ...jhiAuthPermResEntity,
        ...values
      };

      if (this.state.isNew) {
        this.props.createEntity(entity);
      } else {
        this.props.updateEntity(entity);
      }
      this.handleClose();
    }
  };

  handleClose = () => {
    this.props.history.push('/entity/jhi-auth-perm-res-my-suffix');
  };

  jhiPermissionUpdate = element => {
    const id = element.target.value.toString();
    if (id === '') {
      this.setState({
        jhiPermissionId: -1
      });
    } else {
      for (const i in this.props.jhiPermissions) {
        if (id === this.props.jhiPermissions[i].id.toString()) {
          this.setState({
            jhiPermissionId: this.props.jhiPermissions[i].id
          });
        }
      }
    }
  };

  jhiResourceUpdate = element => {
    const id = element.target.value.toString();
    if (id === '') {
      this.setState({
        jhiResourceId: -1
      });
    } else {
      for (const i in this.props.jhiResources) {
        if (id === this.props.jhiResources[i].id.toString()) {
          this.setState({
            jhiResourceId: this.props.jhiResources[i].id
          });
        }
      }
    }
  };

  render() {
    const { jhiAuthPermResEntity, jhiPermissions, jhiResources, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="departmentSecurityApp.jhiAuthPermRes.home.createOrEditLabel">
              <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.home.createOrEditLabel">
                Create or edit a JhiAuthPermRes
              </Translate>
            </h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : jhiAuthPermResEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="id">
                      <Translate contentKey="global.field.id">ID</Translate>
                    </Label>
                    <AvInput id="jhi-auth-perm-res-my-suffix-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="authorityNameLabel" for="authorityName">
                    <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.authorityName">Authority Name</Translate>
                  </Label>
                  <AvField id="jhi-auth-perm-res-my-suffix-authorityName" type="text" name="authorityName" />
                </AvGroup>
                <AvGroup>
                  <Label id="permissionNameLabel" for="permissionName">
                    <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.permissionName">Permission Name</Translate>
                  </Label>
                  <AvField id="jhi-auth-perm-res-my-suffix-permissionName" type="text" name="permissionName" />
                </AvGroup>
                <AvGroup>
                  <Label id="resourceNameLabel" for="resourceName">
                    <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.resourceName">Resource Name</Translate>
                  </Label>
                  <AvField id="jhi-auth-perm-res-my-suffix-resourceName" type="text" name="resourceName" />
                </AvGroup>
                <AvGroup>
                  <Label for="jhiPermission.id">
                    <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.jhiPermission">Jhi Permission</Translate>
                  </Label>
                  <AvInput
                    id="jhi-auth-perm-res-my-suffix-jhiPermission"
                    type="select"
                    className="form-control"
                    name="jhiPermission.id"
                    onChange={this.jhiPermissionUpdate}
                  >
                    <option value="" key="0" />
                    {jhiPermissions
                      ? jhiPermissions.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.id}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <AvGroup>
                  <Label for="jhiResource.id">
                    <Translate contentKey="departmentSecurityApp.jhiAuthPermRes.jhiResource">Jhi Resource</Translate>
                  </Label>
                  <AvInput
                    id="jhi-auth-perm-res-my-suffix-jhiResource"
                    type="select"
                    className="form-control"
                    name="jhiResource.id"
                    onChange={this.jhiResourceUpdate}
                  >
                    <option value="" key="0" />
                    {jhiResources
                      ? jhiResources.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.id}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/jhi-auth-perm-res-my-suffix" replace color="info">
                  <FontAwesomeIcon icon="arrow-left" />&nbsp;
                  <span className="d-none d-md-inline">
                    <Translate contentKey="entity.action.back">Back</Translate>
                  </span>
                </Button>
                &nbsp;
                <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                  <FontAwesomeIcon icon="save" />&nbsp;
                  <Translate contentKey="entity.action.save">Save</Translate>
                </Button>
              </AvForm>
            )}
          </Col>
        </Row>
      </div>
    );
  }
}

const mapStateToProps = (storeState: IRootState) => ({
  jhiPermissions: storeState.jhiPermission.entities,
  jhiResources: storeState.jhiResource.entities,
  jhiAuthPermResEntity: storeState.jhiAuthPermRes.entity,
  loading: storeState.jhiAuthPermRes.loading,
  updating: storeState.jhiAuthPermRes.updating
});

const mapDispatchToProps = {
  getJhiPermissions,
  getJhiResources,
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(JhiAuthPermResMySuffixUpdate);
