import React from 'react';
import styled from 'styled-components';
import { Outlet } from 'react-router-dom';
import Card from '../../components/shared/Card';

const RecoverContainer = styled.div`
  display: grid;
  gap: ${({ theme }) => theme.spacing.lg};
`;

const Title = styled.h1`
  font-family: ${({ theme }) => theme.typography.fontFamilies.heading};
  font-size: ${({ theme }) => theme.typography.fontSize['2xl']};
  color: ${({ theme }) => theme.colors.text.primary};
  margin-bottom: ${({ theme }) => theme.spacing.md};
`;

const Recover: React.FC = () => {
  return (
    <RecoverContainer>
      <Card>
        <Title>Recover</Title>
        <p>Optimize your rest and recovery for better performance.</p>
      </Card>
      <Outlet />
    </RecoverContainer>
  );
};

export default Recover;
