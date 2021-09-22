import React from "react";
import { Button } from "@material-ui/core";

const CustomButton: React.FC<{
  onClick: () => void;
  name: string;
  style: { textTransform: string; fontSize: string; color: string };
  disabled: boolean;
}> = (props: any) => {
  return (
    <Button
      style={props.style}
      onClick={props.onClick}
      disabled={props.disabled}
    >
      {props.name}
    </Button>
  );
};

export default CustomButton;
