import React from 'react';
import styled from 'styled-components';
import Card from '../components/shared/Card';

const HomeContainer = styled.div`
  display: grid;
  gap: ${({ theme }) => theme.spacing.lg};
  max-width: 1200px;
  margin: 0 auto;
`;

const WelcomeCard = styled(Card)`
  text-align: center;
  padding: ${({ theme }) => theme.spacing.xl};
`;

const Title = styled.h1`
  font-family: ${({ theme }) => theme.typography.fontFamilies.heading};
  font-size: ${({ theme }) => theme.typography.fontSize['3xl']};
  color: ${({ theme }) => theme.colors.text.primary};
  margin-bottom: ${({ theme }) => theme.spacing.md};
`;

const Home: React.FC = () => {
  return (
    <HomeContainer>
      <WelcomeCard>
        <Title>Welcome to 4-Score Fitness</Title>
        <p>Your journey to optimal fitness begins here.</p>
      </WelcomeCard>
    </HomeContainer>
  );
};

export default Home;
