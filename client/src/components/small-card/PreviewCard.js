import React from 'react';
import styled from 'styled-components';

import ImageContainer from 'components/small-card/ImageContainer';
import ContentContainer from 'components/small-card/ContentsContainer';

const PreviewCard = ({ title, content, category, image, hashtag }) => {
  return (
    <Container>
      <ImgContainer>
        {image ? (
          <img src={image} alt="카드 이미지" />
        ) : (
          <NullImageContainer>썸네일을 넣어주세요.</NullImageContainer>
        )}
      </ImgContainer>
      <ContentContainer
        title={title}
        content={content}
        category={category}
        hashtag={hashtag}
      />
    </Container>
  );
};

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  border-radius: 10px;
  width: 25vw;
`;

const ImgContainer = styled.div`
  display: flex;
  overflow: hidden;
  border-radius: 10px;
  width: 100%;
  min-width: 200px;
  max-width: 550px;
  height: 20vw;
  min-height: 300px;
  max-height: 500px;
  box-shadow: 0 3px 5px rgba(0, 0, 0, 0.13), 0 3px 3px rgba(0, 0, 0, 0.13);
  
  img {
    overflow: hidden;
    object-fit: cover;
    width: 100%;
    height: 100%;
    transition: all 0.4s cubic-bezier(0.25, 0.8, 0.25, 1);
    &:hover {
      transform: scale(1.1);
    }
`;

const NullImageContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 10px;
  width: 100%;
  height: 100%;
  background-color: #98999d;
`;

export default PreviewCard;
