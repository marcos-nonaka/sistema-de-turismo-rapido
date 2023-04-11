import React from 'react'
import { render, screen } from '@testing-library/react'
import Navuser from './Navuser'

test('renders login page', () => {
	render(<Navuser />)
})