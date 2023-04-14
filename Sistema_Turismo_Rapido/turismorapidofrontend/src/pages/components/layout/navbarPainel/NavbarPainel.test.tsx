import React from 'react'
import { render, screen } from '@testing-library/react'
import NavbarPainel from './NavbarPainel'

test('renders login page', () => {
	render(<NavbarPainel />)
})