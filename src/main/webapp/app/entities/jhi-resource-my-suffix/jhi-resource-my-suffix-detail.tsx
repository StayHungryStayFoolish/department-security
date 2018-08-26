import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './jhi-resource-my-suffix.reducer';
import { IJhiResourceMySuffix } from 'app/shared/model/jhi-resource-my-suffix.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IJhiResourceMySuffixDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: number }> {}

export class JhiResourceMySuffixDetail extends React.Component<IJhiResourceMySuffixDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { jhiResourceEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="departmentSecurityApp.jhiResource.detail.title">JhiResource</Translate> [<b>{jhiResourceEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="resourceName">
                <Translate contentKey="departmentSecurityApp.jhiResource.resourceName">Resource Name</Translate>
              </span>
            </dt>
            <dd>{jhiResourceEntity.resourceName}</dd>
          </dl>
          <Button tag={Link} to="/entity/jhi-resource-my-suffix" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>&nbsp;
          <Button tag={Link} to={`/entity/jhi-resource-my-suffix/${jhiResourceEntity.id}/edit`} replace color="primary">
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

const mapStateToProps = ({ jhiResource }: IRootState) => ({
  jhiResourceEntity: jhiResource.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(JhiResourceMySuffixDetail);
