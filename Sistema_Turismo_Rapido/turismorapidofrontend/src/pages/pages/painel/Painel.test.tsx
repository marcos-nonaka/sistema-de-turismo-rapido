import React from 'react'
import { render, screen } from '@testing-library/react'
import Painel from './Painel'

test('renders login page', () => {
    render(<Painel />)
})