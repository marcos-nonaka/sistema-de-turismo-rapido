import React from 'react'
import { render, screen } from '@testing-library/react'
import Signup from './Signup'

test('renders login page', () => {
    render(<Signup />)
})