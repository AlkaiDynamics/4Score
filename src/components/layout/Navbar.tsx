import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { FiBell, FiSettings, FiUser } from 'react-icons/fi';

const Nav = styled.nav`
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: ${({ theme }) => theme.spacing.md};
  background-color: ${({ theme }) => theme.colors.background.light};
  border-radius: ${({ theme }) => theme.borderRadius.lg};
  margin-bottom: ${({ theme }) => theme.spacing.lg};
`;

const Logo = styled(Link)`
  font-family: ${({ theme }) => theme.typography.fontFamilies.heading};
  font-size: ${({ theme }) => theme.typography.fontSize.xl};
  color: ${({ theme }) => theme.colors.text.primary};
  text-decoration: none;
  font-weight: ${({ theme }) => theme.typography.fontWeights.bold};
`;

const NavActions = styled.div`
  display: flex;
  gap: ${({ theme }) => theme.spacing.md};
`;

const IconButton = styled(Link)`
  color: ${({ theme }) => theme.colors.text.secondary};
  font-size: ${({ theme }) => theme.typography.fontSize.lg};
  transition: color ${({ theme }) => theme.transitions.fast};
  
  &:hover {
    color: ${({ theme }) => theme.colors.text.primary};
  }
`;

const Navbar: React.FC = () => {
  return (
    <Nav>
      <Logo to="/">4-Score</Logo>
      <NavActions>
        <IconButton to="/notifications">
          <FiBell />
        </IconButton>
        <IconButton to="/settings">
          <FiSettings />
        </IconButton>
        <IconButton to="/profile">
          <FiUser />
        </IconButton>
      </NavActions>
    </Nav>
  );
};

export default Navbar;
