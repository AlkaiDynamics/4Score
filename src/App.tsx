import React from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { ThemeProvider } from 'styled-components';
import { AuthProvider } from './contexts/AuthContext';
import ProtectedRoute from './components/auth/ProtectedRoute';
import { GlobalStyles } from './styles/GlobalStyles';
import { theme } from './config/theme';
import { ROUTES } from './config/constants';

// Auth Pages
const Login = React.lazy(() => import('./pages/auth/Login'));
const Register = React.lazy(() => import('./pages/auth/Register'));
const ForgotPassword = React.lazy(() => import('./pages/auth/ForgotPassword'));

// Core Pages
const Home = React.lazy(() => import('./pages/Home'));
const MainLayout = React.lazy(() => import('./components/layout/MainLayout'));

// F.O.U.R. pages
const Forge = React.lazy(() => import('./pages/forge'));
const Optimize = React.lazy(() => import('./pages/optimize'));
const Unite = React.lazy(() => import('./pages/unite'));
const Recover = React.lazy(() => import('./pages/recover'));

const App: React.FC = () => {
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyles />
      <AuthProvider>
        <BrowserRouter>
          <React.Suspense fallback={<div>Loading...</div>}>
            <Routes>
              {/* Public Routes */}
              <Route
                path={ROUTES.LOGIN}
                element={
                  <ProtectedRoute requireAuth={false}>
                    <Login />
                  </ProtectedRoute>
                }
              />
              <Route
                path={ROUTES.REGISTER}
                element={
                  <ProtectedRoute requireAuth={false}>
                    <Register />
                  </ProtectedRoute>
                }
              />
              <Route
                path={ROUTES.FORGOT_PASSWORD}
                element={
                  <ProtectedRoute requireAuth={false}>
                    <ForgotPassword />
                  </ProtectedRoute>
                }
              />

              {/* Protected Routes */}
              <Route element={<MainLayout />}>
                <Route
                  path={ROUTES.HOME}
                  element={
                    <ProtectedRoute>
                      <Home />
                    </ProtectedRoute>
                  }
                />
                
                {/* F.O.U.R. Routes */}
                <Route path={ROUTES.FORGE.ROOT} element={<ProtectedRoute><Forge /></ProtectedRoute>}>
                  <Route path={ROUTES.FORGE.WORKOUT} />
                  <Route path={ROUTES.FORGE.HISTORY} />
                  <Route path={ROUTES.FORGE.PROGRAMS} />
                </Route>

                <Route path={ROUTES.OPTIMIZE.ROOT} element={<ProtectedRoute><Optimize /></ProtectedRoute>}>
                  <Route path={ROUTES.OPTIMIZE.NUTRITION} />
                  <Route path={ROUTES.OPTIMIZE.MEAL_PLAN} />
                  <Route path={ROUTES.OPTIMIZE.TRACKING} />
                </Route>

                <Route path={ROUTES.UNITE.ROOT} element={<ProtectedRoute><Unite /></ProtectedRoute>}>
                  <Route path={ROUTES.UNITE.COMMUNITY} />
                  <Route path={ROUTES.UNITE.CHALLENGES} />
                  <Route path={ROUTES.UNITE.LEADERBOARD} />
                </Route>

                <Route path={ROUTES.RECOVER.ROOT} element={<ProtectedRoute><Recover /></ProtectedRoute>}>
                  <Route path={ROUTES.RECOVER.SLEEP} />
                  <Route path={ROUTES.RECOVER.STRESS} />
                  <Route path={ROUTES.RECOVER.MOBILITY} />
                </Route>
              </Route>

              {/* Catch all route */}
              <Route path="*" element={<Navigate to={ROUTES.HOME} replace />} />
            </Routes>
          </React.Suspense>
        </BrowserRouter>
      </AuthProvider>
    </ThemeProvider>
  );
};

export default App;
