import React from 'react'
import { render, screen } from '@testing-library/react'
import MyItineraries from './MyItineraries'

test('renders login page', () => {
    render(<MyItineraries />)
    const linkElement = screen.getByText(/MyItineraries/i)
    expect(linkElement).toBeInTheDocument()
})
