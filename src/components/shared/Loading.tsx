import React from 'react';
import styled, { keyframes } from 'styled-components';

interface LoadingProps {
  size?: 'sm' | 'md' | 'lg';
}

const spin = keyframes`
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
`;

const getSpinnerSize = (size: LoadingProps['size']) => {
  switch (size) {
    case 'sm':
      return '16px';
    case 'lg':
      return '48px';
    case 'md':
    default:
      return '32px';
  }
};

const SpinnerContainer = styled.div<LoadingProps>`
  width: ${({ size = 'md' }) => getSpinnerSize(size)};
  height: ${({ size = 'md' }) => getSpinnerSize(size)};
  border: 2px solid ${({ theme }) => theme.colors.background.light};
  border-top-color: ${({ theme }) => theme.colors.primary.navy};
  border-radius: 50%;
  animation: ${spin} 1s linear infinite;
`;

const Loading: React.FC<LoadingProps> = ({ size = 'md' }) => {
  return <SpinnerContainer size={size} />;
};

export default Loading;
