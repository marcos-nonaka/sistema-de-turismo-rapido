import React, { Component } from 'react';

interface img {
  url: string
}


function ImageComponent(props: img) {
  return (
    <img className="Avatar"
         src={props.url}
         alt={props.url} />
  );
}

export default ImageComponent;