import React from "react";

import Typography from "@material-ui/core/Typography";

const getMappedVariant = (variant: string) => {
  switch (variant) {
    case "header":
      return "h6";
    case "title":
      return "subtitle1";
    case "subtitle":
      return "subtitle2";
    default:
      return "body1";
  }
};

const TypographyComponent = (props: any) => {
  const { variant, children } = props;

  return (
    <Typography variant={getMappedVariant(variant)} noWrap>
      {children}
    </Typography>
  );
};

export default TypographyComponent;
