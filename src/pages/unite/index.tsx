import React from 'react';
import styled from 'styled-components';
import { Outlet } from 'react-router-dom';
import Card from '../../components/shared/Card';

const UniteContainer = styled.div`
  display: grid;
  gap: ${({ theme }) => theme.spacing.lg};
`;

const Title = styled.h1`
  font-family: ${({ theme }) => theme.typography.fontFamilies.heading};
  font-size: ${({ theme }) => theme.typography.fontSize['2xl']};
  color: ${({ theme }) => theme.colors.text.primary};
  margin-bottom: ${({ theme }) => theme.spacing.md};
`;

const Unite: React.FC = () => {
  return (
    <UniteContainer>
      <Card>
        <Title>Unite</Title>
        <p>Connect with like-minded individuals and build your fitness community.</p>
      </Card>
      <Outlet />
    </UniteContainer>
  );
};

export default Unite;
