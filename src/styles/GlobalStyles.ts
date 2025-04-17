import { createGlobalStyle } from 'styled-components';
import { theme } from '../config/theme';

export const GlobalStyles = createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  body {
    font-family: ${theme.typography.fontFamilies.body};
    background-color: ${theme.colors.background.dark};
    color: ${theme.colors.text.primary};
    line-height: 1.5;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
  }

  a {
    color: inherit;
    text-decoration: none;
  }

  button {
    background: none;
    border: none;
    cursor: pointer;
    font-family: inherit;
  }

  input, button {
    outline: none;
  }

  h1, h2, h3, h4, h5, h6 {
    font-family: ${theme.typography.fontFamilies.heading};
    font-weight: ${theme.typography.fontWeights.bold};
  }

  img {
    max-width: 100%;
    height: auto;
  }

  ::selection {
    background-color: ${theme.colors.primary.navy};
    color: ${theme.colors.text.primary};
  }
`;
