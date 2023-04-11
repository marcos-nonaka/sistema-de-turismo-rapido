import React from 'react'
import { render, screen } from '@testing-library/react'
import RegisterDestination from './RegisterDestination'

test('renders login page', () => {
    render(<RegisterDestination />)
    const linkElement = screen.getByText(/RegisterDestination/i)
    expect(linkElement).toBeInTheDocument()
})
