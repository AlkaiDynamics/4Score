import React from 'react';
import styled, { css } from 'styled-components';

type ButtonVariant = 'primary' | 'secondary' | 'outline' | 'ghost';
type ButtonSize = 'sm' | 'md' | 'lg';

interface ButtonProps extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  variant?: ButtonVariant;
  size?: ButtonSize;
  isLoading?: boolean;
  fullWidth?: boolean;
}

const getButtonStyles = (variant: ButtonVariant, theme: any) => {
  switch (variant) {
    case 'primary':
      return css`
        background-color: ${theme.colors.primary.navy};
        color: ${theme.colors.text.primary};
        &:hover:not(:disabled) {
          background-color: ${theme.colors.primary.red};
        }
      `;
    case 'secondary':
      return css`
        background-color: ${theme.colors.secondary.gold};
        color: ${theme.colors.text.primary};
        &:hover:not(:disabled) {
          opacity: 0.9;
        }
      `;
    case 'outline':
      return css`
        background-color: transparent;
        border: 2px solid ${theme.colors.primary.navy};
        color: ${theme.colors.primary.navy};
        &:hover:not(:disabled) {
          background-color: ${theme.colors.primary.navy}10;
        }
      `;
    case 'ghost':
      return css`
        background-color: transparent;
        color: ${theme.colors.text.primary};
        &:hover:not(:disabled) {
          background-color: ${theme.colors.background.light};
        }
      `;
  }
};

const getButtonSize = (size: ButtonSize, theme: any) => {
  switch (size) {
    case 'sm':
      return css`
        padding: ${theme.spacing.xs} ${theme.spacing.sm};
        font-size: ${theme.typography.fontSize.sm};
      `;
    case 'md':
      return css`
        padding: ${theme.spacing.sm} ${theme.spacing.md};
        font-size: ${theme.typography.fontSize.md};
      `;
    case 'lg':
      return css`
        padding: ${theme.spacing.md} ${theme.spacing.lg};
        font-size: ${theme.typography.fontSize.lg};
      `;
  }
};

const StyledButton = styled.button<ButtonProps>`
  display: inline-flex;
  align-items: center;
  justify-content: center;
  border: none;
  border-radius: ${({ theme }) => theme.borderRadius.md};
  font-weight: ${({ theme }) => theme.typography.fontWeights.medium};
  cursor: pointer;
  transition: all ${({ theme }) => theme.transitions.fast};
  gap: ${({ theme }) => theme.spacing.sm};
  width: ${({ fullWidth }) => fullWidth ? '100%' : 'auto'};

  ${({ variant = 'primary', theme }) => getButtonStyles(variant, theme)}
  ${({ size = 'md', theme }) => getButtonSize(size, theme)}

  &:disabled {
    opacity: 0.6;
    cursor: not-allowed;
  }
`;

const Button: React.FC<ButtonProps> = ({ 
  children, 
  variant = 'primary',
  size = 'md',
  isLoading,
  fullWidth,
  disabled,
  ...props 
}) => {
  return (
    <StyledButton
      variant={variant}
      size={size}
      fullWidth={fullWidth}
      disabled={disabled || isLoading}
      {...props}
    >
      {isLoading ? 'Loading...' : children}
    </StyledButton>
  );
};

export default Button;
