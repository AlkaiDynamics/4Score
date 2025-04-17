import React from 'react';
import styled from 'styled-components';
import { Outlet } from 'react-router-dom';
import Card from '../../components/shared/Card';

const ForgeContainer = styled.div`
  display: grid;
  gap: ${({ theme }) => theme.spacing.lg};
`;

const Title = styled.h1`
  font-family: ${({ theme }) => theme.typography.fontFamilies.heading};
  font-size: ${({ theme }) => theme.typography.fontSize['2xl']};
  color: ${({ theme }) => theme.colors.text.primary};
  margin-bottom: ${({ theme }) => theme.spacing.md};
`;

const Forge: React.FC = () => {
  return (
    <ForgeContainer>
      <Card>
        <Title>Forge</Title>
        <p>Build strength and endurance through targeted workouts.</p>
      </Card>
      <Outlet />
    </ForgeContainer>
  );
};

export default Forge;
