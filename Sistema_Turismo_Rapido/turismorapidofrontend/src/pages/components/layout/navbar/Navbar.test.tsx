import React from 'react'
import { render, screen } from '@testing-library/react'
import Navbar from './Navbar'

test('renders login page', () => {
	render(<Navbar />)
})