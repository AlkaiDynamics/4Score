import React from 'react';
import styled, { css } from 'styled-components';

interface CardProps {
  variant?: 'default' | 'elevated';
  padding?: 'none' | 'sm' | 'md' | 'lg';
  children: React.ReactNode;
}

const getCardPadding = (padding: CardProps['padding'], theme: any) => {
  switch (padding) {
    case 'none':
      return '0';
    case 'sm':
      return theme.spacing.sm;
    case 'lg':
      return theme.spacing.lg;
    case 'md':
    default:
      return theme.spacing.md;
  }
};

const StyledCard = styled.div<CardProps>`
  background-color: ${({ theme }) => theme.colors.background.light};
  border-radius: ${({ theme }) => theme.borderRadius.lg};
  padding: ${({ padding = 'md', theme }) => getCardPadding(padding, theme)};

  ${({ variant }) =>
    variant === 'elevated' &&
    css`
      box-shadow: ${({ theme }) => theme.shadows.md};
    `}
`;

const Card: React.FC<CardProps> = ({ children, variant = 'default', padding = 'md' }) => {
  return (
    <StyledCard variant={variant} padding={padding}>
      {children}
    </StyledCard>
  );
};

export default Card;
