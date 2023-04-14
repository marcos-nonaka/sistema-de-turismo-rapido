import React from 'react'
import { render, screen } from '@testing-library/react'
import Booking from './Booking'

test('renders login page', () => {
    render(<Booking />)
    const linkElement = screen.getByText(/Booking/i)
    expect(linkElement).toBeInTheDocument()
})
