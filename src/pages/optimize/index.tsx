import React from 'react';
import styled from 'styled-components';
import { Outlet } from 'react-router-dom';
import Card from '../../components/shared/Card';

const OptimizeContainer = styled.div`
  display: grid;
  gap: ${({ theme }) => theme.spacing.lg};
`;

const Title = styled.h1`
  font-family: ${({ theme }) => theme.typography.fontFamilies.heading};
  font-size: ${({ theme }) => theme.typography.fontSize['2xl']};
  color: ${({ theme }) => theme.colors.text.primary};
  margin-bottom: ${({ theme }) => theme.spacing.md};
`;

const Optimize: React.FC = () => {
  return (
    <OptimizeContainer>
      <Card>
        <Title>Optimize</Title>
        <p>Enhance your performance through nutrition and supplementation.</p>
      </Card>
      <Outlet />
    </OptimizeContainer>
  );
};

export default Optimize;
