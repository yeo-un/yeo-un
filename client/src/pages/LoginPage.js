import React, { useState } from 'react';
import styled from 'styled-components';
import { withRouter } from 'react-router-dom';
import axios from 'axios';

import Logo from 'components/Logo';
import { Checkbox } from '@material-ui/core';

const URL = 'http://493600167198.ngrok.io';

const LoginPage = (props) => {
  const [id, setId] = useState('');
  const [pw, setPw] = useState('');

  const onChangeIdInput = (e) => {
    setId(e.target.value);
  };

  const onChangePwInput = (e) => {
    setPw(e.target.value);
  };

  const onClickSignInButton = () => {
    props.history.push('/signin');
  };

  const onClickLoginButton = () => {
    if (id !== '' && pw !== '') {
      axios({
        url: `${URL}/api/member/sign-in`,
        method: 'post',
        Member: {
          email: id,
          password: pw,
        },
      }).then((res) => {
        console.log(res);
      });
    }
  };

  return (
    <Container>
      <Logo />
      <Border>
        <HeaderText>Welcome to Yeoun!</HeaderText>
        <Explain>로그인을 통해 서비스를 이용하실 수 있습니다.</Explain>
        <Cover>
          <p>Email</p>
          <Input type="text" onChange={onChangeIdInput} value={id} />
          <p>Password</p>
          <Input type="password" onChange={onChangePwInput} value={pw} />

          <div>
            <Button>Sign in</Button>
            <Button onClick={onClickSignInButton}>Join</Button>
          </div>
        </Cover>
      </Border>
    </Container>
  );
};

const Container = styled.div`
  display: flex;
  flex-direction: column;
  height: 100vh;
  justify-content: center;
  align-items: center;
`;

const Explain = styled.p`
  font-size: 12px;
`;

const Border = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 70vh;
  background-color: #f7f7f7;
  border: 1px outset black;
  border-radius: 10px;
`;
const Cover = styled.div`
  margin: 30px;
  padding: 30px;
`;

const Input = styled.input`
  border: 1px solid black;
  margin: 10px;
  padding: 10px;
  width: 250px;
  border-radius: 10px;
  background-color: white;
`;

const Button = styled.button`
  display: block;
  width: 250px;
  border: 1px solid black;
  border-radius: 10px;
  background-color: #37373d;
  cursor: pointer;
  margin: 10px;
  padding: 10px;
  text-align: center;
  color: white;
`;

const HeaderText = styled.p`
  font-size: 18px;
  font-weight: 600;
`;

export default withRouter(LoginPage);