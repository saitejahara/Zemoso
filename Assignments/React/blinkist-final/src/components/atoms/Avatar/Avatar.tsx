import React from "react";
import Avatar from "@material-ui/core/Avatar";

const Avatars = (props: any) => {
  return (
    <div>
      <Avatar alt={props.alt} src={props.src} />
    </div>
  );
};

export default Avatars;
