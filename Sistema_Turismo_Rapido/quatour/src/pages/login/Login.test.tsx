import React from 'react'
import { render, screen } from '@testing-library/react'
import Login from './Login'

test('renders login page', () => {
    render(<Login />)
    const linkElement = screen.getByText(/quatour/i)
    expect(linkElement).toBeInTheDocument()
})

