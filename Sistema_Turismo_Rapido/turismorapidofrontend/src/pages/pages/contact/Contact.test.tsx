import React from 'react'
import { render, screen } from '@testing-library/react'
import Contact from './Contact'

test('renders login page', () => {
    render(<Contact />)
})