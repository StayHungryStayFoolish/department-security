import React from 'react';
import { DropdownItem } from 'reactstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { Translate, translate } from 'react-jhipster';
import { NavLink as Link } from 'react-router-dom';
import { NavDropdown } from '../header-components';

export const EntitiesMenu = props => (
  // tslint:disable-next-line:jsx-self-close
  <NavDropdown icon="th-list" name={translate('global.menu.entities.main')} id="entity-menu">
    <DropdownItem tag={Link} to="/entity/jhi-department-my-suffix">
      <FontAwesomeIcon icon="asterisk" />&nbsp;<Translate contentKey="global.menu.entities.jhiDepartmentMySuffix" />
    </DropdownItem>
    <DropdownItem tag={Link} to="/entity/jhi-permission-my-suffix">
      <FontAwesomeIcon icon="asterisk" />&nbsp;<Translate contentKey="global.menu.entities.jhiPermissionMySuffix" />
    </DropdownItem>
    <DropdownItem tag={Link} to="/entity/jhi-resource-my-suffix">
      <FontAwesomeIcon icon="asterisk" />&nbsp;<Translate contentKey="global.menu.entities.jhiResourceMySuffix" />
    </DropdownItem>
    <DropdownItem tag={Link} to="/entity/jhi-auth-perm-res-my-suffix">
      <FontAwesomeIcon icon="asterisk" />&nbsp;<Translate contentKey="global.menu.entities.jhiAuthPermResMySuffix" />
    </DropdownItem>
    {/* jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here */}
  </NavDropdown>
);
