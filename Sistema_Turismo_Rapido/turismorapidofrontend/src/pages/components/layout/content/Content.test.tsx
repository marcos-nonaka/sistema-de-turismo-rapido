import React from 'react'
import { render, screen } from '@testing-library/react'
import Content from './Content'

test('renders login page', () => {
	render(<Content />)
})