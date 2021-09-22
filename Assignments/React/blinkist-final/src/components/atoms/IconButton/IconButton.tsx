import React, { ReactElement } from "react";
import PropTypes from "prop-types";

import IconButton from "@material-ui/core/IconButton";

const IconButtonComponent: React.FC<{
  icon: ReactElement<any, any>;
  disabled?: boolean;
  onClick?: () => void;
  color?: string;
}> = (props: any) => {
  return (
    <IconButton
      color={props.color}
      disabled={props.disabled}
      onClick={props.onClick}
    >
      {props.icon}
    </IconButton>
  );
};

export default IconButtonComponent;
