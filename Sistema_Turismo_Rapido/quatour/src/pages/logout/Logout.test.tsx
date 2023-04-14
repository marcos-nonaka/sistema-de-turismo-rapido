import React from 'react'
import { render, screen } from '@testing-library/react'
import Logout from './Logout'

test('renders login page', () => {
    render(<Logout />)
    const linkElement = screen.getByText(/quatour/i)
    expect(linkElement).toBeInTheDocument()
})

