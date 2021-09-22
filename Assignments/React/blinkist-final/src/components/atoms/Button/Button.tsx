import React from "react";
import Button from "@material-ui/core/Button";

const ButtonComponent = (props: any) => {
  return (
    <Button {...props}>
      <b>{props.name} </b>
    </Button>
  );
};

export default ButtonComponent;
