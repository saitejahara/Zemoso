import React from "react";

import TextField from "@material-ui/core/TextField";

const InputFieldComponent: React.FC<{
  label?: string;
  value?: string;
  require?: string;
  className?: string;
  id?: string;
  onChange?: (e: any) => void;
  onBlur?: string;
  type?: string;
  error?: string;
  helper?: string;
  variant?: string;
}> = (props: any) => {
  return (
    <TextField
      fullWidth
      label={props.label}
      className={props.className}
      defaultValue={props.value}
      required={props.required}
      onChange={props.onChange}
      error={props.error}
      helperText={props.helper}
      type={props.type}
      onBlur={props.onBlur}
      variant={props.variant}
      InputLabelProps={{
        shrink: true,
      }}
    />
  );
};

export default InputFieldComponent;
