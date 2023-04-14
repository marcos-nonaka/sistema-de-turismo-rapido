import React from 'react'
import { render, screen } from '@testing-library/react'
import ItinerarySearch from './ItinerarySearch'

test('renders login page', () => {
    render(<ItinerarySearch />)
    const linkElement = screen.getByText(/ItinerarySearch/i)
    expect(linkElement).toBeInTheDocument()	
})