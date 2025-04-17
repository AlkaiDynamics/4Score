import React, { useState } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { useFormik } from 'formik';
import * as Yup from 'yup';
import Card from '../../components/shared/Card';
import Input from '../../components/shared/Input';
import Button from '../../components/shared/Button';
import { ROUTES } from '../../config/constants';
import { resetPassword, AuthError } from '../../utils/firebase/auth';
import { motion, AnimatePresence } from 'framer-motion';

const AuthContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  padding: ${({ theme }) => theme.spacing.lg};
  background-color: ${({ theme }) => theme.colors.background.dark};
`;

const AuthCard = styled(Card)`
  width: 100%;
  max-width: 400px;
`;

const Form = styled.form`
  display: flex;
  flex-direction: column;
  gap: ${({ theme }) => theme.spacing.md};
`;

const Title = styled.h1`
  font-family: ${({ theme }) => theme.typography.fontFamilies.heading};
  font-size: ${({ theme }) => theme.typography.fontSize['2xl']};
  color: ${({ theme }) => theme.colors.text.primary};
  margin-bottom: ${({ theme }) => theme.spacing.sm};
  text-align: center;
`;

const Subtitle = styled.p`
  color: ${({ theme }) => theme.colors.text.secondary};
  text-align: center;
  margin-bottom: ${({ theme }) => theme.spacing.lg};
  font-size: ${({ theme }) => theme.typography.fontSize.sm};
`;

const LinkText = styled(Link)`
  color: ${({ theme }) => theme.colors.primary.navy};
  text-decoration: none;
  text-align: center;
  margin-top: ${({ theme }) => theme.spacing.md};
  
  &:hover {
    text-decoration: underline;
  }
`;

const Message = styled(motion.div)<{ $success?: boolean }>`
  color: ${({ theme, $success }) =>
    $success ? theme.colors.success : theme.colors.error};
  background-color: ${({ theme, $success }) =>
    $success ? theme.colors.success + '20' : theme.colors.error + '20'};
  padding: ${({ theme }) => theme.spacing.sm};
  border-radius: ${({ theme }) => theme.borderRadius.sm};
  text-align: center;
  margin-top: ${({ theme }) => theme.spacing.sm};
`;

const ForgotPassword: React.FC = () => {
  const [error, setError] = useState<string | null>(null);
  const [success, setSuccess] = useState<boolean>(false);
  const [loading, setLoading] = useState(false);

  const validationSchema = Yup.object({
    email: Yup.string()
      .email('Please enter a valid email address')
      .required('Email is required')
  });

  const formik = useFormik({
    initialValues: {
      email: ''
    },
    validationSchema,
    onSubmit: async (values) => {
      setLoading(true);
      setError(null);
      setSuccess(false);

      try {
        const result = await resetPassword(values.email);
        
        if (result && 'code' in result) {
          const authError = result as AuthError;
          setError(authError.visual);
        } else {
          setSuccess(true);
          formik.resetForm();
        }
      } catch (err) {
        setError('An unexpected error occurred. Please try again.');
      } finally {
        setLoading(false);
      }
    }
  });

  return (
    <AuthContainer>
      <AuthCard>
        <Form onSubmit={formik.handleSubmit} noValidate>
          <Title>Reset Password</Title>
          <Subtitle>
            Enter your email address and we'll send you instructions to reset your password.
          </Subtitle>

          <Input
            type="email"
            name="email"
            placeholder="Email"
            value={formik.values.email}
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            error={formik.touched.email ? formik.errors.email : undefined}
            disabled={loading}
            aria-label="Email address"
          />

          <Button
            type="submit"
            disabled={loading || !formik.isValid}
            aria-busy={loading}
          >
            {loading ? 'Sending Instructions...' : 'Send Reset Instructions'}
          </Button>

          <AnimatePresence>
            {(error || success) && (
              <Message
                $success={success}
                initial={{ opacity: 0, y: -10 }}
                animate={{ opacity: 1, y: 0 }}
                exit={{ opacity: 0, y: -10 }}
                role="alert"
              >
                {success
                  ? 'Password reset instructions have been sent to your email.'
                  : error}
              </Message>
            )}
          </AnimatePresence>

          <LinkText to={ROUTES.LOGIN}>
            Back to Sign In
          </LinkText>
        </Form>
      </AuthCard>
    </AuthContainer>
  );
};

export default ForgotPassword;
