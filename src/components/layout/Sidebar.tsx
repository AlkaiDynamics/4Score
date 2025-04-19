import React from 'react';
import styled from 'styled-components';
import { NavLink } from 'react-router-dom';
import { FiHome, FiActivity, FiCoffee, FiUsers, FiMoon } from 'react-icons/fi';
import { ROUTES } from '../../config/constants';

const SidebarContainer = styled.aside`
  position: fixed;
  left: 0;
  top: 0;
  bottom: 0;
  width: 240px;
  background-color: ${({ theme }) => theme.colors.background.light};
  padding: ${({ theme }) => theme.spacing.lg};
  display: flex;
  flex-direction: column;
  gap: ${({ theme }) => theme.spacing.md};

  @media (max-width: ${({ theme }) => theme.breakpoints.md}) {
    transform: translateX(-100%);
  }
`;

const NavItem = styled(NavLink)`
  display: flex;
  align-items: center;
  gap: ${({ theme }) => theme.spacing.md};
  padding: ${({ theme }) => theme.spacing.sm} ${({ theme }) => theme.spacing.md};
  color: ${({ theme }) => theme.colors.text.secondary};
  text-decoration: none;
  border-radius: ${({ theme }) => theme.borderRadius.md};
  transition: all ${({ theme }) => theme.transitions.fast};
  font-weight: ${({ theme }) => theme.typography.fontWeights.medium};

  &:hover {
    background-color: ${({ theme }) => theme.colors.primary.navy}20;
    color: ${({ theme }) => theme.colors.text.primary};
  }

  &.active {
    background-color: ${({ theme }) => theme.colors.primary.navy};
    color: ${({ theme }) => theme.colors.text.primary};
  }
`;

const NavSection = styled.div`
  display: flex;
  flex-direction: column;
  gap: ${({ theme }) => theme.spacing.sm};

  &:not(:last-child) {
    padding-bottom: ${({ theme }) => theme.spacing.lg};
    border-bottom: 1px solid ${({ theme }) => theme.colors.background.dark};
  }
`;

const NavHeader = styled.h3`
  color: ${({ theme }) => theme.colors.text.secondary};
  font-size: ${({ theme }) => theme.typography.fontSize.sm};
  text-transform: uppercase;
  letter-spacing: 1px;
  margin-bottom: ${({ theme }) => theme.spacing.sm};
`;

const Sidebar: React.FC = () => {
  return (
    <SidebarContainer>
      <NavSection>
        <NavHeader>Core</NavHeader>
        <NavItem to={ROUTES.HOME}>
          <FiHome /> Home
        </NavItem>
      </NavSection>

      <NavSection>
        <NavHeader>F.O.U.R.</NavHeader>
        <NavItem to={ROUTES.FORGE.ROOT}>
          <FiActivity /> Forge
        </NavItem>
        <NavItem to={ROUTES.OPTIMIZE.ROOT}>
          <FiCoffee /> Optimize
        </NavItem>
        <NavItem to={ROUTES.UNITE.ROOT}>
          <FiUsers /> Unite
        </NavItem>
        <NavItem to={ROUTES.RECOVER.ROOT}>
          <FiMoon /> Recover
        </NavItem>
      </NavSection>
    </SidebarContainer>
  );
};

export default Sidebar;
